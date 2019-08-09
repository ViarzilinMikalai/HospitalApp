<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
    <h1>List of departments</h1>


    <table class="table table-bordered table-sm">
        <thead class="thead-light">
        <tr>
            <th scope="col">Отделение</th>
            <th scope="col">Удалено</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody >
                <#list departmentsList as dept>
                <tr class="${dept.deleted?then('table-danger', '')}">
                    <td>${dept.name}</td>
                    <td>${dept.deleted?then('true', 'false')}</td>
                    <td>
                        ${dept.deleted?then('<a href="/departments?repareDepartment=${dept.id}">Repare</a>',
                        '<a href="/departments?removeDepartment=${dept.id}">Delete</a>')}
                    </td>
                    <td><a href="/departments?department=${dept.id}">edit</a>
                    </td>
                </tr>
                <#else>
                       <h2>Departments list is empty</h2>
                </#list>
        </tbody>
    </table>

    <#if savingReport??><div class="alert alert-danger" role="alert">${savingReport}</div></#if>
    <#include "parts/departmentEditForm.ftl"/>

</@pt.page>
