package com.daytrade.model.factory;

import com.daytrade.model.GeneralOrganization;
import com.daytrade.model.ITOrganization;

public class ITOrganizationFactory implements OrganizationFactory {
    @Override
    public ITOrganization createOrganization() {
        return new ITOrganization();
    }
}
