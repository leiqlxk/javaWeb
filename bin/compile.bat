set catalina_home=D:\apache-tomcat-9.0.29
set path=%path%;C:\Program Files\Java\jdk1.8.0_231\bin

set currpath=..\
cd ..
if "%OS%" == "Windows_NT" set currpath=%cd%

set src=%currpath%\src
set dest=%currpath%\web\WEB-INF\classes
set classpath=%catalina_home%\lib\servlet-api.jar;%catalina_home%\lib\jsp-api.jar

javac -sourcepath %src% -d %dest% %src%\com\lql\servlet\DispatcherServlet.java
javac -sourcepath %src% -d %dest% %src%\com\lql\tag\HelloTag.java

pause