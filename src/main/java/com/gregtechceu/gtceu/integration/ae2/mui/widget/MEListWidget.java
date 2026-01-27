package com.gregtechceu.gtceu.integration.ae2.mui.widget;

import com.gregtechceu.gtceu.api.mui.base.value.ISyncOrValue;
import com.gregtechceu.gtceu.api.mui.widget.Widget;
import com.gregtechceu.gtceu.api.mui.widgets.layout.Row;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class MEListWidget extends Row {

    @Override
    public boolean isValidSyncOrValue(@NotNull ISyncOrValue syncOrValue) {
        return syncOrValue.isTypeOrEmpty(Map.class);
    }
}
