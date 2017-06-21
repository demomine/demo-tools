# FTP
##  FTP基础知识
1.  FTP是仅基于TCP的服务，不支持UDP。 FTP使用2个端口，一个数据端口(20)和一个命令端口(21)（也可叫做控制端口）。
2.  两种连接模式
    主动模式和被动模式
##  FTP服务器架设
1.  安装vsftpd
```
yum -y install vsftpd
systemctl vsftpd start
```
2.  安装客户端
```
rpm -Uvh http://mirror.centos.org/centos/6/os/x86_64/Packages/ftp-0.17-54.el6.x86_64.rpm
```
3.  配置vsftpd
    *   详细配置`http://yuanbin.blog.51cto.com/363003/108262/`
        ```
        /etc/vsftpd/vsftpd.conf 主配置文件 
        
        /etc/vsftpd.ftpusers 指定哪些用户不能访问FTP服务器 
        
        /etc/vsftpd.user_list 文件中指定的用户是否可以访问ftp服务器由vsftpd.conf文件中的userlist_deny的取值来决定。 
        
        usermod -s /sbin/nologin ftp2   禁止ssh登录
        ```
4.  默认配置
    *   默认根目录为 `/var/ftp/pub`
    
5.  常用配置
    *   chroot_local_user  YES 时，chroot_list_enable=YES时， 所有用户都可以ftp连接，限制在主目录下面。  启用chroot_list_file里面的用户名单，作为例外，不限制访问范围
    
    *   chroot_local_user=NO 时，chroot_list_enable=YES 时，  所有用户都可以ftp连接，不限制范围。         启用chroot_list_file里面的用户名单，作为例外，限制访问范围在主目录
    
    *   chroot_local_user=NO 时，chroot_list_enable=NO 时，   所有用户可以ftp连接，不限制范围。           不启用 chroot_list_file里面的用户名单，没有例外
    
    *   hroot_local_user =YES 时，chroot_list_enable=NO 时，   所有用户可以ftp连接，限制在主目录下        不启用chroot_list_file里面的用户名单，没有例外
        
6.  常见问题
    *   `refusing to run with writable root inside chroot()`
        *   原因:用户的根目录可写，并且使用了chroot限制，而这在最近的更新里是不被允许的
        *   解决方案:   `chmod a-w /home/user`去除用户根目录的写权限，注意把目录替换成你自己的 \
                或者:   `allow_writeable_chroot=YES`
           
    *   `Create directory operation failed`
        *   原因: 文件夹没有写权限
        *   解决方案:   `chmod 755 /home/ftptest` ,`chown ftptest /home/ftptest`
        
##  FTP知识
1.  FTP传输模式 ASCII和BINARY区别
    `http://wjy1208.iteye.com/blog/685359`
2.  被动模式和主动模式区别
    `http://pengshao.iteye.com/blog/1136965`
3.  防火墙对ftp的影响
    `http://www.cnblogs.com/emanlee/archive/2013/01/07/2849680.html`
4.  PORT/PASV/EPRT/EPSV区别
    `https://my.oschina.net/u/572632/blog/283460`
5.  FTPClient API存取设计
    `http://blog.csdn.net/i_lovefish/article/details/18455215`
    
        
  