<#--<#import pager.ftl as p>-->

<#--<@p.pager url page/>-->

    <table class="table table-bordered table-sm">
        <thead class="thead-light">
        <tr>
            <th scope="col">Фамилия </th>
            <th scope="col">Имя</th>
            <th scope="col">Отчество</th>
            <th scope="col">Дата рождения</th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody >
                <#list patients as patient>
                <tr>
                    <td>${patient.lastname}</td>
                    <td>${patient.firstname}</td>
                    <td>${patient.surname}</td>
                    <td>${patient.birthDate}</td>
                    <td><a href="/allpatients?patient=${patient.id}">edit</a></td>
                </tr>
                </#list>
        </tbody>
    </table>
<#--</@p.pager url page/>-->