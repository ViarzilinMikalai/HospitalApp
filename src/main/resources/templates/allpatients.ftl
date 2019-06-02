<#import "parts/pageTemplate.ftl" as pt>

<@pt.page>
    <h1>List of patients</h1>


    <div class="form-row">
        <div class="form-group col-md-6">
            <form method="get" action="allpatients" class="form-inline">
                <input type="text" name="lastnameFilter" value="${lastnameFilter?ifExists}"
                       placeholder="Search by Lastname" class="form-control">
                <input type="text" name="firstnameFilter" value="${firstnameFilter?ifExists}"
                       placeholder="Search by Firstname" class="form-control">
                <button type="submit" class="btn btn-primary ml-2">Search</button>
            </form>
        </div>
    </div>

    <#include "parts/patientList.ftl"/>
    <#include "parts/patientEditForm.ftl"/>

</@pt.page>
