package com.cybertek.tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class LoginToNBcrmW_excel {

    XSSFWorkbook workbook;
    XSSFSheet sheet;
    FileInputStream fileInputStream;
    LoginPage loginPage = new LoginPage();

    @Test
    public void  Username_From_Excel() throws IOException {

        for (int i = 0; i < 3; i++) {


            Driver.getDriver().get(ConfigurationReader.getProperty("url"));

            String path = "src/test/resources/testData/LoginToNBcrm.xlsx";

            //loading the file into fileinputStream Object
            fileInputStream = new FileInputStream(path);

            //loading the workbook to the class
            workbook = new XSSFWorkbook(fileInputStream);

            //getting the sheet from workbook
            sheet = workbook.getSheet("Credentials");

            for (int rowNum = 2, cellNum = 0; rowNum <= sheet.getLastRowNum(); cellNum++, rowNum++) {
                XSSFRow currentRow = sheet.getRow(rowNum);
                XSSFCell currentCell = sheet.getRow(rowNum).getCell(cellNum);

                String username = currentRow.getCell(0).getStringCellValue();

                String password = currentRow.getCell(1).getStringCellValue();

                loginPage.userNameBox.sendKeys(username);
                BrowserUtils.wait(2);
                loginPage.passwordBox.sendKeys(password);
                BrowserUtils.wait(2);
                loginPage.loginButton.click();
                BrowserUtils.wait(2);
                Driver.closeDriver();
            }

        }
    }



}
