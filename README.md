# Projeto Biblioteca

This is a college project and have as main objective to put in practice our knowledge about web development using Java EE, and any other technology we may think necessary in the project.

This system is build to be used in a library management, the core functions are:

<ul>
    <li>Students Management
        <ol>
            <li>Include Sudents</li>
            <li>Update Students</li>
        </ol>
    </li>
</ul>

<ul>
    <li>Employee Management
        <ol>
            <li>Include Employee</li>
            <li>Delete Employee</li>
            <li>Update Employee</li>
        </ol>
    </li>
</ul>

<ul>
    <li>Book Management
        <ol>
            <li>Include Book</li>
            <li>Update Book</li>
        </ol>
    </li>
</ul>

<ul>
    <li>Library Management
        <ol>
            <li>Include Library</li>
            <li>Delete Library</li>
            <li>Update Library</li>
        </ol>
    </li>
</ul>

<ul>
    <li>Genre Management
        <ol>
            <li>Include Genre</li>
            <li>Delete Genre</li>
            <li>Update Genre</li>
        </ol>
    </li>
</ul>

Search functions are included in the pages, for help the usability. A report system was included as well, but not all functionalities are working,i may say its 90% finished.

The books lend can be renewed after 15 days and a new column in the books table will show the next availability of a borrow book.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

What things you need to install the software and how to install them.

In order to run the project, you will need the following:

<ol>
    <li>Eclipse IDE - I personaly recomend Mars version.</li>
    <li>PostgreSQL - You can find a SQL with the database <a href="https://github.com/AdrianoCh/projetoBiblioteca/blob/master/DataBase/DB.txt">here</a>, you need to paste each block of code sperately in a SQL executener.</li>
    <li>PgAdmin - You will need to manage the database, and to do the instruction above.</li>
    <li>Tomcat - We used the 8.0 version, its the most compatible.</li>
    <li>JDK.</li>
    <li>Build Path - You need to do <a href="https://github.com/AdrianoCh/projetoBiblioteca/tree/master/BuildPath"> this</a> before run for the first time</li>
</ol>

### Installing

Import the WAR file to your Eclipse, or clone all master branch and paste in your workspace(if you dont have much experience with Java i highly recomed you to import the WAR file).

Ensure that Tomcat is configured and running.

Build Path fallowing this [instrucions](https://github.com/AdrianoCh/projetoBiblioteca/tree/master/BuildPath)

Run the project in server.

## Built With

* [Eclipse IDE](http://www.eclipse.org/downloads/eclipse-packages/)
* [Visual Studio Code](https://code.visualstudio.com/)
* [Brackets](http://brackets.io/)

## Contributing

Feel free to contribute, submit pull requests for us.
## Authors

* **Adriano Chaves** - [AdrianoCh](https://github.com/AdrianoCh)
* **Carlos** - [alocairo](https://github.com/alocairo)

## License

This project is licensed under the GNU License - see the [LICENSE.md](LICENSE.md) file for details