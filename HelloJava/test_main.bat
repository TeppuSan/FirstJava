@echo off
javac -encoding UTF-8 -cp "HelloJava/lib/postgresql-42.7.6.jar" -d HelloJava/bin HelloJava/src/Fatality/Main.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo.
    echo Running...
    java -cp "HelloJava/bin;HelloJava/lib/postgresql-42.7.6.jar" Fatality.Main

) else (
    echo Compilation error occurred.
    echo.
    echo Check the following:
    echo - Source file exists
    echo - JDBC driver is in lib folder
    echo - Japanese comment encoding
)
echo Press any key to exit...
pause 