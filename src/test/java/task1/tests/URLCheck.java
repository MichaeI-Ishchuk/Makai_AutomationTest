package task1.tests;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import task1.BaseTest;
import org.testng.annotations.Test;

public class URLCheck extends BaseTest {



    @Test(groups = { "init" })
    @Parameters({"url","fileName"})

    public void urlCheck(String url, String fileName) throws Exception {

        actions.urlCheck(url, fileName);

          }
    @Test(groups = { "init" })
    @Parameters({"url","fileName","id"})

    public void urlCheckByData(String url, String fileName, int id) throws Exception {
        if (id==1)
        {actions.urlCheckOtherByData(url, fileName);}

        else{actions.urlCheckByData(url, fileName);}

    }
    @Test(dependsOnGroups = { "init.*" })
       public void pixelCheck() throws Exception {

        Assert.assertTrue(actions.list.get(0).equals(actions.list.get(1)),"are not matched pixels");

    }

}
