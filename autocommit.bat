@echo off

set /p commit_name=Title of commit: 
if "%commit_name%" == "" goto endmessage
echo Select branch to push:
echo 1) All
echo 2) development-backend
echo 3) development-web
echo 4) development-misc
set /p branch_setting=
if "%branch_setting%" == "1" (
    git add .
	git commit -m "%commit_name%"
	git push origin development-backend
	git push origin development-web
	git push origin development-misc
) else if "%branch_setting%" == "2" (
    git add .
	git commit -m "%commit_name%"
	git push origin development-backend
) else if "%branch_setting%" == "3" (
    git add .
	git commit -m "%commit_name%"
	git push origin development-web
) else if "%branch_setting%" == "4" (
    git add .
	git commit -m "%commit_name%"
	git push origin development-misc
) else (
    goto endmessage
)
goto end

:endmessage
echo Aborting...

:end
