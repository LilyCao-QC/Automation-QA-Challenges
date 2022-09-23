import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

'Open web browser'
WebUI.openBrowser('')

'Access Signup page'
s_URL = WebUI.concatenate((([GlobalVariable.homepage, GlobalVariable.signIn]) as String[]), FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(s_URL)

'Enter invalid email'
WebUI.setText(findTestObject('Object Repository/SignIn/Page_Conduit/input_Have an account_form-control form-control-lg_1'), 
    email)

'Enter password'
WebUI.setText(findTestObject('Object Repository/SignIn/Page_Conduit/input_Have an account_form-control form-control-lg_1_2'), 
    password)

'Click Sign In button'
WebUI.click(findTestObject('Object Repository/SignIn/Page_Conduit/button_Sign in'))

'Verify error message appears'
WebUI.verifyElementText(findTestObject('Object Repository/SignIn/Page_Conduit/li_email or password is invalid'), 'email or password is invalid')

'Close web browser'
WebUI.closeBrowser()

