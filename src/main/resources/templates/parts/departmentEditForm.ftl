<a class="btn btn-primary mb-3" data-toggle="collapse" href="#collapseExample" role="button" aria-expanded="false" aria-controls="collapseExample">
    Department editor
</a>

    <div class="collapse <#if department??>show</#if>" id="collapseExample">
        <div class="form-group mt-3">
            <form method="post">
                <div class="form-group">
                    <input type="text" name="name" placeholder="Department"
                           class="form-control ${(nameError??)?string('is-invalid', '')}"
                           value="<#if department??>${department.name}</#if>"/>
                    <#if nameError??>
                        <div class="invalid-feedback">
                            ${nameError}
                        </div>
                    </#if>
                </div>
                <div class="form-group mt-2">
                    <button type="submit" class="btn btn-primary">
                        <#if !department??>
                            Create department
                        <#else>
                            <#if department.id??>
                                Update department
                            </#if>
                            <#if !department.id??>
                                Create department
                            </#if>
                        </#if>
                    </button>
                </div>
            </form>
        </div>
    </div>