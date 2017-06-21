package com.lance.demo.ftp;

import org.apache.commons.net.ftp.FTPClient;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by perdonare on 2017/6/20.
 */
public class FtpDemoTest {
    @Test
    public void download() throws Exception {
        FtpDemo ftpDemo = new FtpDemo();
        FTPClient ftpClient = ftpDemo.login("192.168.1.72",0,"ftptest","ftptest");
        ftpDemo.downloadFile(ftpClient,"/aaa","你好","/data/appLogs");
        ftpDemo.downloadFile(ftpClient,"/aaa","test.txt","/data/appLogs");
        ftpDemo.disconnect(ftpClient);
    }
}