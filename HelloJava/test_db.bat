@echo off
REM ========================================================
REM PostgreSQL Database Connection Test Batch File
REM ========================================================
REM 
REM This batch file performs the following:
REM 1. Compile DatabaseTest.java
REM 2. Execute the program if compilation succeeds
REM 3. Display error message if compilation fails
REM
REM Usage:
REM - Run in HelloJava directory
REM - Ensure PostgreSQL server is running
REM - Ensure database d_test exists
REM
REM Required files:
REM - src/Fatality/DatabaseTest.java (source code)
REM - lib/postgresql-42.7.6.jar (JDBC driver)
REM ========================================================

echo PostgreSQL Database Connection Test
echo =================================

echo.
echo Compiling...
REM Compile with UTF-8 encoding for Japanese comments
REM -cp: specify classpath (include JDBC driver)
REM -d bin: specify output directory
javac -encoding UTF-8 -cp "lib/postgresql-42.7.6.jar" -d bin src/Fatality/DatabaseTest.java

REM Check compilation result
REM %ERRORLEVEL%: exit code of previous command
REM EQU 0: success (no error)
if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo.
    echo Running...
    REM Execute with classpath including bin directory and JDBC driver
    REM bin;lib/postgresql-42.7.6.jar: use semicolon as separator on Windows
) else (
    echo Compilation error occurred.
    echo.
    echo Check the following:
    echo - Source file exists
    echo - JDBC driver is in lib folder
    echo - Japanese comment encoding
)

echo.
echo Press any key to exit...
pause 