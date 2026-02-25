# Jenkins Deployment Workflow

# Step 1: Java Project:
Inside `src`, there is a simple Springboot project that has a few tests. We run it through the Maven Lifecycle by `mvn clean verify`

# Step 2: Start Jenkins and Forward A Port on VSCode:
You can forward a port on VSCode by clicking on the `PORTS` tab in the terminal window. There is only one button, termed `Forward a Port`. Once that is clicked, the visibility of the port exposed (in the URL provided) must be changed from `private` to `public`

![Port Forwarding](<assets/jenkins-asset (3).png>)

# Step 3: Create a new github repository and configure a Github webhook
Creating a new Github repository and push the code to the remote repository is trivial. Once that is done, go to the repository's `Settings -> Webhook -> Add Webhook`

![Github webhook setup](<assets/jenkins-asset (11).png>)

Once there, paste the dev tunnel URL with the endpoint `/github-webhook/` and change the Content type to `application/json`

# Step 4: Jenkins Configuration Changes:

1. Add Credentials (either username/password OR personal access token)
![Credentials](<assets/jenkins-asset (9).png>)

2. Add Github server (So it uses your Personal access token to access the webhook)
![Github server](<assets/jenkins-asset (10).png>)

# Step 5: Setup the Jenkins CI Job

![General 1](<assets/jenkins-asset (4).png>)

![General 2](<assets/jenkins-asset (5).png>) 

Credentials are `none` because the repository is public.

![General 3](<assets/jenkins-asset (6).png>)

A lot of repositories would need this to be changed to `main` from `master`

#### IMPORTANT:
![GITHUB HOOK POLLING](<assets/jenkins-asset (7).png>)

Tick this checkbox to ensure Jenkins knows to poll the github repository for push triggers!

![Build](<assets/jenkins-asset (8).png>)

# Step 6: Enjoy the taste of success

![Success!](<assets/jenkins-asset (12).png>)

The line `Started by GitHub push by araowis` (a username that hasn't been configured anywhere in jenkins, it has pulled this from github) shows that yes, indeed, our CI pipeline is working as expected.


