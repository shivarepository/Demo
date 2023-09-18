Feature: LoginApp
Scenario: Verify Login Verification
Given User open the Website "https://opensource-demo.orangehrmlive.com/" with Login Page
When User login with "UserId" and "Password"
Then Application should login
And Home Page should be displayed 