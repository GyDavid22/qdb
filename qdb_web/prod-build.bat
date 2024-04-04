@echo off
rd /s /q .angular
rd /s /q dist
node_modules\.bin\ng build --base-href="/java/"