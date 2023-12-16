# Clean Architecture Form Validation Without Compose
<br>
<p align="center">This is simple clean architecture validation with XML.</p>
 <br>

 ## Project Screens
<table align="center">
<tr>
 <td>
  <p align="center"><b>Error State Screen</b></p>
 </td>
 <td>
  <p align="center"><b>Success State Screen</b></p>
 </td>
</tr>
<tr>
 <td> 
  <img src="https://user-images.githubusercontent.com/94524411/235961042-931a4439-add5-4779-a1b7-fe06520b9f31.png" width=200>
 </td>
 <td>
  <img src="https://user-images.githubusercontent.com/94524411/235960407-594a8a2b-9bfd-4a07-8762-16a9803b3365.png" width=200>
 </td>
</tr>
</table>

## Project Tech Stack
<ul>
 <li>This project developed with %100 with <a href="https://kotlinlang.org/">Kotlin</a></li>
 <li>Developed with <a href="https://developer.android.com/topic/architecture">Android Architecture Components</a>, provide the Collection of libraries that help you design robust, testable, and maintainable apps.</li>
 <li><a href="https://developer.android.com/topic/libraries/architecture/viewmodel?hl=tr"><b>View Model</b></a>: The ViewModel class is a business logic or screen level state holder. In this project used to pass values of inputs to business logic, validate form objects, listen events and report to ui.</li>
 <li><a href="https://developer.android.com/kotlin/flow"><b>Kotlin Flow</b></a>: In coroutines, a flow is a type that can emit multiple values sequentially, as opposed to suspend functions that return only a single value. In this project used to pass value of inputs as live to the business logic and listen to the answer. </li>
 <li><a href="https://developer.android.com/kotlin/coroutines"><b>Kotlin Coroutine</b></a>: On Android, coroutines help to manage long-running tasks that might otherwise block the main thread and cause your app to become unresponsive. In this project used to wait to response from the validation and do change into ui according to the answer.</li>
</ul>

## Project Graph
This project developed by MVVM(Model-View-ViewModel) architecture.
<ul>
 <li>Common Layer : Common layer usually used for functions, classes, etc. common to the whole project. In this project used to hide FormEvent and FormState class, this classes used to the take validation response and pass inputs to validation classes</li>
 <li>Domain Layer : Domain layer usually used for communicate between data source and project. In this project used to hide validation use-cases because not block the ui layer during the control phase.</li>
 <li>Presentation Layer : Presentation layer usually used hide ui pages. In this project hide viewModel and view page.</li>
</ul>

## Reference
<ul>
 <li>
  Philipp Lackner How to Validate Forms with Clean Architecture (You're Doing it Wrong);<br>
https://www.youtube.com/watch?v=zu8lQSVw4vk
 </li>
 <li>
  Github repo;<br>
https://github.com/dracula151997/FormValidationCleanArchitecture</li>
 <li>
  Github repo;<br>
https://github.com/raheemadamboev/clean-architecture-validation</li>
</ul>

## End Note
I may have mistakes, you can contact me for your feedback. 👉 📫 **eren.mollaoglu@outlook.com**<br>
