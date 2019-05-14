<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
    <h1>List of patients</h1>
    <table>
        <thead>
        <tr>
            <th>Фамилия </th>
            <th>Имя</th>
            <th>Отчество</th>
            <th>Дата рождения</th>
        </tr>
        </thead>
        <tbody>
            <#list patients as patient>
            <tr>
                <td>${patient.lastname}</td>
                <td>${patient.firstname}</td>
                <td>${patient.surname}</td>
                <td>${patient.birthDate}</td>
                <td>edit</td>
            </tr>
            </#list>
        </tbody>
    </table>



</body>
</html>