# vridBlogApp

A simple Android application that serves as a client for a blog, built using modern Android development practices.

This project is intended to demonstrate a clean, scalable architecture using the latest Android libraries.

## 🚀 Tech Stack

This project leverages a modern tech stack to create a robust and maintainable application:

- **UI:** [Jetpack Compose](https://developer.android.com/jetpack/compose) for a fully declarative and modern UI.
- **Architecture:** MVVM (Model-View-ViewModel) to separate business logic from the UI.
- **Asynchronous Programming:** [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) for managing background threads and simplifying async code.
- **Navigation:** [Jetpack Navigation Compose](https://developer.android.com/jetpack/compose/navigation) for handling navigation between screens.
- **Networking:** [Retrofit](https://square.github.io/retrofit/) and [OkHttp](https://square.github.io/okhttp/) for making efficient network requests to the blog's API.
- **JSON Parsing:** [Moshi](https://github.com/square/moshi) for fast and reliable JSON serialization and deserialization, with compile-time code generation via [KSP](https://kotlinlang.org/docs/ksp-overview.html).

## 🏗️ Architecture (MVVM)

This project follows the Model-View-ViewModel (MVVM) architectural pattern to ensure a clean separation of concerns and promote a scalable and testable codebase.

```
      +----------------+      +----------------+      +----------------+
      |      View      |      |   ViewModel    |      |      Model     |
      | (Compose UI)   |      | (Business Logic) |      | (Data Layer)   |
      +-------+--------+      +--------+-------+      +--------+-------+
              |                        |                       |
              | observes State &       |                       |
              | sends Events           |                       |
              +----------------------> |                       |
                                       |                       |
              <----------------------+                       |
               (updates UI with State) |                       |
                                       |                       |
                                       | fetches/updates Data  |
                                       +---------------------> |
                                                               |
                                       <---------------------+                       
                                        (provides Data)      |
                                                               |
      +----------------+      +----------------+      +----------------+
      |  (User)        |      |                |      | (Repository,   |
      |                |      |                |      |  API, Database)|
      +----------------+      +----------------+      +----------------+
```

### Components

-   **View (UI Layer):** Built with Jetpack Compose. Observes state from the `ViewModel` and sends user events to it. It has no direct knowledge of business logic.
-   **ViewModel:** Contains the business logic for the screen. It receives events from the View and interacts with the Model (Repository) to fetch or update data.
-   **Model (Data Layer):** Manages the application's data using the Repository pattern. It acts as the single source of truth, fetching data from remote (API) or local sources.

## 📸 Screenshots

Here are some screenshots of the app in action:

| Blog List | Blog Detail |
| :---: | :---: |
| ![Blog List Screen](screenshots/blog_detail_screen.png) | ![Blog Detail Screen](./screenshots/blog_detail_screen.png) |

## 🛠️ How to Build

1.  Clone the repository: `git clone https://github.com/nakulcharak002/vridBlog`
2.  Open the project in a recent version of Android Studio.
3.  Let Gradle sync and download the required dependencies.
4.  Build and run the app on an emulator or a physical device.
