# CompaniesService

java Rest Api made in Netbeans, this rest is the API for CompaniesList angular client. This Rest is create 
from database and still working on it, you can see the database creation at the SQL file.

# Versions used
- Mysql Conector 5.14
- Java EE7
- GlasshFish 4.1.2

# Other tips for set up
  - When making the mysql database conecction in Netbeans, the user cannot be a sudo user to 
  connect it on netbeans(mysql now do roots by default like that),You will now if it's like
  that because you login using this  (sudo mysql -u root -p).
Just create a user and put privileges (if you can login like that "mysql -u newUser -p", it's okay)

  - If the JDBC Resource and pool are not generated in glasshfish server when you create them in project 
right click->new->other->glashfish-$"right click in glassfish server->View domain admin console->
resources-> add resources->browse xml-> browse glassfish-resources.xml of $

 - Glasshfish 4.1.2 has a bug and doesn't produce Json correctly, you see this
Could not initialize class org.eclipse.persistence.jaxb.BeanValidationHelper and the solution
 (https://stackoverflow.com/questions/33722764/glassfish-error-when-producing-json) or use another version


# Usefull example sources
 - https://www.youtube.com/watch?v=IvqakwjjHhg

                                               









