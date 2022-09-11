#  ✧&nbsp;&nbsp;&nbsp;✡︎✮&nbsp;&nbsp; ✦ ✨️ L&emsp;&emsp;U&emsp;&emsp;N&emsp;&emsp;A ✨ ✫❍&nbsp;&nbsp;&nbsp;❈ &nbsp;&nbsp;✶

## About Luna ☀️
Luna is your nature-themed graphical user interface (GUI) desktop app that is sure to help you complete your tasks in the prettiest way possible 🌻

## Features 🌤

### Add and delete tasks

Add or delete various tasks like:
- todo 🌸
- deadline 🌺
- event 🌼

### Update task statuses

Completed your task? 
- Mark your task as done 🍃

Still need to work on more on your task?
- Unmark your task 🍂

### View and search for tasks
- List and view all your tasks 🌷
- Search by keyword for specific tasks 🌹


## User Guide 🌥

### 1. `todo` 🌸

Create a new 'todo'.

Tell Luna your command in the format: 

`todo <task description>`

Example:
```
Input: 
    todo ip
Output:
    Luna has added:
    [T][ ] ip
    1 task(s) left in your list 🌻
```
---
### 2. `deadline` 🌺
Create a new `deadline` task with a date to complete the task by.

Tell Luna your command in the format:

`deadline <task description> /by <yyyy-MM-dd>`

Example:
```
Input: 
    deadline wash laundry /by 2022-09-16
Output: 
    Luna has added:
    [D][ ] wash laundry BY 16 Sep 2022
    2 task(s) left in your list 🌻
```
---
### 3. `event` 🌼
Create a new `event` with its occurrence date.
Tell Luna your command in the format:

`event <event description> /at <yyyy-MM-dd>`

Example:
```
Input: 
    event meet bestie /at 2022-09-16
Output: 
    Luna has added:
    [E][ ] meet bestie AT 16 Sep 2022
    3 task(s) left in your list 🌻
```
---
### 4. `list` 💐

View all your tasks.

Tell Luna your command in the format:

`list`

Example:
```
Input: 
    list
Output: 
    ☀️ Stuff you have to do! ☀️
        1. [T][ ] ip
        2. [D][ ] wash laundry BY 16 Sep 2022
        3. [E][ ] meet bestie AT 16 Sep 2022
```
---
### 5. `mark` 🌹
Update the status of a specific task in your list as completed.

Tell Luna your command in the format:

`mark <task number>`

Example:
```
Input: 
    mark 2
Output: 
    Marked as completed 🌈️
    [D][✧] wash laundry BY 16 Sep 2022
```
### 4. `unmark` 🥀
Update the status of a specific task in your list as uncompleted.

Tell Luna your command in the format:

`unmark <task number>`

Example:
```
Input: 
    unmark 2
Output: 
    Marked as uncompleted 🌩
    [D][ ] wash laundry BY 16 Sep 2022
```
---
### 5. `find` 🌷
Search for specific tasks in your list by a keyword.

Tell Luna your command in the format:

`find <keyword>`

Example:

```
Input:
    find laundry
Output:
    ☁️ Here are the tasks Luna has found! ☁️
        1. [D][ ] wash laundry BY 16 Sep 2022
```
---
### 6. `bye` 💐
Exit Luna. 

**⚡️ Please only use this command to exit Luna instead of closing the window, 
or Luna will not be able to save your tasks to storage! ⚡️** 

Tell Luna your command in the format:

`bye`