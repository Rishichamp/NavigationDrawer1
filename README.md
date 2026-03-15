# Navigation Drawer Android App

This Android project demonstrates how to implement a **Navigation Drawer using Java, Fragments, and AndroidX components** in Android Studio.

The app provides a side navigation menu that allows users to switch between different sections of the application.

---

## Features

- Navigation Drawer integrated with Toolbar
- Fragment-based navigation
- Home menu loads a fragment
- Notes and Settings menu options
- Toast messages on menu selection
- Drawer closes automatically after item selection
- Back button closes the drawer if open

---

## Technologies Used

- Java
- Android Studio
- AndroidX Libraries
- DrawerLayout
- NavigationView
- Toolbar
- Fragments

---

## Project Structure

Main components of the application:

- `MainActivity.java` → Handles Navigation Drawer setup and menu interactions  
- `AFragment.java` → Fragment displayed when the Home option is selected  
- `activity_main.xml` → Layout containing DrawerLayout and NavigationView  
- `navigation_menu.xml` → Defines menu items inside the navigation drawer  

---

## How the App Works

1. The application launches with a **Toolbar and Navigation Drawer icon**.
2. Clicking the icon opens the **side navigation menu**.
3. Available menu options:
   - **Home** → Loads `AFragment`
   - **Notes** → Displays a Toast message
   - **Settings** → Displays a Toast message
4. If the drawer is open, pressing the **Back button closes the drawer** instead of exiting the application.

---

## Screenshots

You can add screenshots of the app interface here.

Example:

![App Screenshot](screenshots/app.png)

---

## Author

Rishi Singh
