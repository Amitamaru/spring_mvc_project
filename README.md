# spring_mvc_project

This is spring boot mvc CRUD application 


To start application you need to do a few steps
1) install docker
2) run SpringMvcProjectApplication from any ide like olways
3) in browser connect http://localhost:8080


All db container will be downloaded and runs inside project conteiner.
In resources you can find init schema.sql (will be run automatically) and data.sql (data.sql run manually, add some demo clients in db if you need)

If you want to manually connect to db. 
Settings wil be:
			
	for user use "root"
	MYSQL_ROOT_PASSWORD: root 
	PORT: 3306
