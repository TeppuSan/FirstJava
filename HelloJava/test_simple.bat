@echo off
echo PostgreSQL Database Connection Test (Simple Version)
echo =================================================

echo.
echo Compiling...
javac -encoding UTF-8 -cp "lib/postgresql-42.7.6.jar" -d bin src/Fatality/DatabaseTestSimple.java

if %ERRORLEVEL% EQU 0 (
    echo Compilation successful!
    echo.
    echo Running...
    java -cp "bin;lib/postgresql-42.7.6.jar" Fatality.DatabaseTestSimple
) else (
    echo Compilation error occurred.
)

echo.
echo Press any key to exit...
pause 