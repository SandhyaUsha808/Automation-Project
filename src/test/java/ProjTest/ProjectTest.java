package ProjTest;
import org.testng.annotations.Test;
import ProjBase.ProjectBase;
import ProjPage.ProjectPage;
import ProjUtil.ProjectUtilities;


public class ProjectTest extends ProjectBase
{

	@Test 
	public void test() throws Exception
	{
		ProjectPage ob=new ProjectPage(driver);
		ob.titleverify();
		ob.linkvalidation();
		ob.logo();
		ob.contentverification();
		ob.fullscreenshot();
		//ob.elementscreenshot();
		String path="D:\\regproject.xlsx";		
		String sheet="Sheet1";
		int count=ProjectUtilities.details(path,sheet);
		for(int i=1;i>=count;i++)
		{
		String uname=ProjectUtilities.values(path, sheet, i, 0);
		String mailid=ProjectUtilities.values(path, sheet, i, 1);
		String pswd=ProjectUtilities.values(path, sheet, i, 2);
		ob.registration(uname,mailid,pswd);
		}
}
}