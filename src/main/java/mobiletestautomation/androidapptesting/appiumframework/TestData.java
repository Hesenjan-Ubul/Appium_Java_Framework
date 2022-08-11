package mobiletestautomation.androidapptesting.appiumframework;

import org.testng.annotations.DataProvider;

public class TestData {

    @DataProvider(name = "InputData")
    public Object[][] getDataforEditField() {
        //2 sets of data, "hello" , "!@#$$"
		return new Object[][]
				{
						{"hello"}, {"@#$%"}
				};

    }

}
