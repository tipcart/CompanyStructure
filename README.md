# CompanyStructure app
CompanyStructure app - application for displaying, adding and searching employees in company. 
Application is composed of 2 screens - first for displaying and searching employees, second for adding new one.

## Functionality
- Displaying list of employees (displaying employee's name and id)
- Adding new employee

## Assumptions
- at the beginning we have initial list of employees
- company structure is kept in memory, not in DB
- employee's id is commonly known for everyone in company (in case when we have more than one employee with the same name, we can choose by employee's id)

## How to use it
- minSdkVersion is set to 21, so you can run the app on device with Lollipop or higher
- after installing and running the application you can see the first screen with initial list of employees
- at the top of screen you can see search icon, after clicking on it, you can put name of employee, which you are looking for
- if there is more than one employee with the same name, you can choose employee by unique id
- if you want to add new employee, click on FAB button in bottom-right corner
- on a new screen put name, age and address of the new employee and click 'ADD' button