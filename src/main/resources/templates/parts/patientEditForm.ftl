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
                           value="<#if patient?? && patient.birthDate??>${birthDates}</#if>"/>
                    <#if birthDateError??>
                        <div class="invalid-feedback">
                            ${birthDateError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" name="city" placeholder="City"
                           class="form-control ${(cityError??)?string('is-invalid', '')}"
                           value="<#if patient?? && patient.city??>${patient.city}</#if>"/>
                    <#if cityError??>
                        <div class="invalid-feedback">
                            ${cityError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" name="street" placeholder="Street"
                           class="form-control ${(streetError??)?string('is-invalid', '')}"
                           value="<#if patient?? && patient.street??>${patient.street}</#if>"/>
                    <#if streetError??>
                        <div class="invalid-feedback">
                            ${streetError}
                        </div>
                    </#if>
                </div>
                <div class="form-group">
                    <input type="text" name="building" placeholder="Building"
                           class="form-control ${(buildingError??)?string('is-invalid', '')}"
                           value="<#if patient?? &&  patient.building??>${patient.building}</#if>"/>
                </div>
                <div class="form-group">
                    <input type="number" name="apartment" placeholder="Apartment"
                           class="form-control ${(apartmentError??)?string('is-invalid', '')}"
                           value="<#if patient?? &&  patient.apartment??>${patient.apartment}</#if>"/>
                    <#if apartmentError??>
                        <div class="invalid-feedback">
                            ${apartmentError}
                        </div>
                    </#if>
                </div>
                <div class="form-group mt-2">
                    <button type="submit" class="btn btn-primary">
                        <#if !patient??>
                            Create Patient
                        <#else>
                            Update Patient
                        </#if>
                    </button>
                </div>
            </form>
        </div>
    </div>