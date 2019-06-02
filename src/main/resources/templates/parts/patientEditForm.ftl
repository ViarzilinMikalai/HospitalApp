    <a class="btn btn-primary mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
        Patient editor
    </a>

    <div class="collapse <#if patient??>show</#if>" id="collapseExample">

        <div class="form-group mt-3">
            <form method="post">
                <div class="form-group">
                    <input type="text" name="lastname" placeholder="Lastname"
                           class="form-control ${(lastnameError??)?string('is-invalid', '')}"
                           value="<#if patient??>${patient.lastname}</#if>"/>
                    <#if lastnameError??>
                        <div class="invalid-feedback">
                            ${lastnameError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" name="firstname" placeholder="Firstname"
                           class="form-control ${(firstnameError??)?string('is-invalid', '')}"
                           value="<#if patient??>${patient.firstname}</#if>"/>
                    <#if firstnameError??>
                        <div class="invalid-feedback">
                            ${firstnameError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" name="surname" placeholder="Surname"
                           class="form-control ${(surnameError??)?string('is-invalid', '')}"
                           value="<#if patient??>${patient.surname}</#if>"/>
                    <#if surnameError??>
                        <div class="invalid-feedback">
                            ${surnameError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="date" name="birthDates" placeholder="2000-01-23"
                           class="form-control ${(birthDateError??)?string('is-invalid', '')}"
                           value="<#if patient??>${birthDates}</#if>"/>
                    <#if birthDateError??>
                        <div class="invalid-feedback">
                            ${birthDateError}
                        </div>
                    </#if>
                </div>
                <div class="form-group mt-2">
                    <button type="submit" class="btn btn-primary">
                        <#if !patient??>
                            Create Patient
                        <#else>
                            Save Patient
                        </#if>
                    </button>
                </div>
            </form>
        </div>
    </div>