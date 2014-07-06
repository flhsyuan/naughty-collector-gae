#!/bin/bash
#
# Title:remote_observation.sh
#
# Description:write mellow elephant observation datum
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"observationList":[{"bssid":"00:1c:10:9e:b5:e9","capability":"[WEP][ESS]","frequency":2462,"locationId":"6d2c4eba-b850-4914-a815-3d719108ee2b","observationId":"a275b36f-8b91-4e50-b766-e0e8ec94163b","ssid":"braingang1","strength":-50,"timeStampMs":1401043497000}], "installationId":"bcf7210f-2ab3-4a66-9cf9-256687d99c46", "sortieId":"e74c1cd8-9464-4126-96d5-f919d5898b27"}' https://mellow-heeler-test.appspot.com/ws/v1/observation
#