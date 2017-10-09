package it.com.ibm.generali.capitalreporting;

import it.com.ibm.generali.capitalreporting.service.NumberCruncher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CapitalReportingApplicationTests
{
    @Autowired
    private NumberCruncher numberCruncher;

    @Test
    public void contextLoadsTest()
    {
    }

    @Test
    public void squareTest()
    {
        int square = this.numberCruncher.square(2);
        assertThat(square, is(4));
    }

}
