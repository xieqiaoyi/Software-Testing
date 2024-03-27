package com.lab2;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.FileHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import static org.junit.Assert.*;

//1）类中要有构造函数
//2）有一个public static的方法被@Parameters标注，并且该方法只能返回
//Iterable类型或数组类型的数据
@RunWith(Parameterized.class)
public class MaxSplitTest {

    private int input;
    private int expected;
    public static Logger logger;
    private MaxSplit maxSplit;

    public MaxSplitTest(int input, int expected) {
        this.input = input;
        this.expected = expected;
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        FileHandler fileHandler = null;
        logger = Logger.getLogger(MaxSplitTest.class.getName());
        try {
            fileHandler = new FileHandler("src\\main\\resources\\test.log", false);
            fileHandler.setFormatter(new SimpleFormatter() {
                @Override
                public String format(LogRecord record) {
                    return record.getLevel() + ":" + new java.util.Date(record.getMillis()) +
                            " " + record.getMessage() + "\n";
                }
            });
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        logger.info("test @BeforeClass ok");
    }

    @Before
    public void setUp() throws Exception {
        maxSplit = new MaxSplit();
        logger.info("test @Before ok");
    }


    @Parameterized.Parameters
    public static List<Integer[]> getdata() throws IOException {
        File file = new File("src\\main\\resources\\testinput.txt");
        InputStreamReader reader = null;
        List<Integer[]> list = new ArrayList<>();
        try {
            reader = new InputStreamReader(new FileInputStream(file));
            BufferedReader br = new BufferedReader(reader);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");
                Integer input = Integer.parseInt(str[0]);
                Integer expected = Integer.parseInt(str[1]);
                list.add(new Integer[]{input, expected});
            }
            reader.close();
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Test
    public void testMaxSplit() {
        int result = maxSplit.maxProduct(input);
        logger.info("test "+input+": inputnumber: "+input+" expectedresult: "+expected+" calculatedresult: "+result);
        assertEquals(expected,result);
        logger.info("test @Test "+input+" ok");
    }

    @After
    public void tearDown() throws Exception {
        logger.info("test @After ok");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        logger.info("test @AfterClass ok");
    }
}