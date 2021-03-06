package datasources.database;

import models.ApiKey;
import models.Application;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ApplicationDatasource {
    public Application findApplicationByPackageAndOrgId(String appPackage, String organizationId) {
        return Application.find
                .fetch("organization")
                .fetch("organization.apiKey")
                .where()
                .eq("appPackage", appPackage)
                .and()
                .eq("organization_id", organizationId)
                .findUnique();
    }

    public Application create(String appPackage, ApiKey apiKey) {
        Application application = new Application();
        application.setAppPackage(appPackage);
        application.setOrganization(apiKey.getOrganization());
        application.save();
        return application;
    }

    public CompletableFuture<List<Application>> findAll() {
        return CompletableFuture.supplyAsync(() -> Application.find.all());
    }
}
