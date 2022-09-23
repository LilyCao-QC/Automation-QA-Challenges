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
s_URL = WebUI.concatenate((([GlobalVariable.homepage, GlobalVariable.signUp]) as String[]), FailureHandling.STOP_ON_FAILURE)

WebUI.navigateToUrl(s_URL)

'Input all required information'
WebUI.setText(findTestObject('Object Repository/Page_Conduit/input_Have an account_form-control form-control-lg'), userName)

WebUI.setText(findTestObject('Object Repository/Page_Conduit/input_Have an account_form-control form-control-lg_1'), email)

WebUI.setText(findTestObject('Object Repository/Page_Conduit/input_Have an account_form-control form-control-lg_1_2'), password)

'Click Sign In button to create new account'
WebUI.click(findTestObject('Object Repository/Page_Conduit/button_Sign in'))

'Verify username displays correctly\r\n'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Conduit/a_qctest'), userName)

'Verify Home page displays as expected\r\n'
WebUI.verifyElementPresent(findTestObject('Object Repository/Page_Conduit/a_Home'), 0)

'\'Your Feed\' tab displays'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Conduit/a_Your Feed'), 'Your Feed')

'\'Global Feed\' tab displays'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Conduit/a_Global Feed'), 'Global Feed')

'Verify this account has no article because it has just created'
WebUI.verifyElementText(findTestObject('Object Repository/Page_Conduit/div_No articles are here. yet'), 'No articles are here... yet.')

WebUI.closeBrowser()

