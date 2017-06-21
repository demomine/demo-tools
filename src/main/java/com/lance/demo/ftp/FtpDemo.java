package com.lance.demo.ftp;

import org.apache.commons.io.FileUtils;
import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.*;
import java.time.LocalDateTime;

/**
 * Created by perdonare on 2017/6/20.
 */
public class FtpDemo {

    public FTPClient login(String hostname, int port, String username, String password) {
        final FTPClient ftpClient = new FTPClient();
        ftpClient.setControlEncoding("utf-8");//防止中文文件名乱码
        int reply;
        try {
            if (port > 0) {
                ftpClient.connect(hostname, port);
            } else {
                ftpClient.connect(hostname);
            }
            reply = ftpClient.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftpClient.disconnect();
                throw new RuntimeException("not positive reply" + reply);
            }
            if (ftpClient.login(username, password)) {
                return ftpClient;
            } else {
                disconnect(ftpClient);
                throw new IOException("login error,username: "+ username);
            }
        } catch (IOException e) {
            disconnect(ftpClient);
            throw new RuntimeException(e);
        }
    }

    public void downloadFile(FTPClient ftpClient, String path, String filename,String localPath) {
        createFileBack(localPath, filename);
        try {
            ftpClient.setFileType(FTP.BINARY_FILE_TYPE);//设置为字节码传输
            ftpClient.enterLocalPassiveMode();//设置为被动传输模式
            ftpClient.setUseEPSVwithIPv4(true);//EPS 支持IPV6
            OutputStream localStream = new FileOutputStream(new File(localPath,filename));
            if (ftpClient.changeWorkingDirectory(path)){
                if (!ftpClient.retrieveFile(filename, localStream)) {
                    localStream.close();
                    disconnect(ftpClient);
                    throw new RuntimeException("file " + filename + " not exists");
                }
            }
            localStream.close();
        } catch (IOException e) {
            disconnect(ftpClient);
            throw new RuntimeException(e);
        }
    }

    public void disconnect(FTPClient ftpClient) {
        if (ftpClient.isConnected()) {
            try {
                ftpClient.logout();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    ftpClient.disconnect();
                } catch (IOException e) {
                    //
                }
            }
        }
    }

    private void createFileBack(String path, String filename) {
        File file = new File(path, filename);
        try {
            FileUtils.forceMkdir(new File(path));
            if (file.exists()){
                FileUtils.copyFile(file,new File(path,filename + "_bak_"+ LocalDateTime.now().toString()));
                FileUtils.forceDelete(file);
            }
            if (!file.createNewFile()) {
                throw new RuntimeException("file "+ filename +" create fail");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
