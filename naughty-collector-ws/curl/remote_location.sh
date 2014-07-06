#!/bin/bash
#
# Title:remote_location.sh
#
# Description:write mellow elephant location datum
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"locationList":[{"locationId":"6d2c4eba-b850-4914-a815-3d719108ee2b","latitude":40.41747695300728,"accuracy":5.0,"longitude":-122.240493837744,"altitude":118.29998779296875,"timeStampMs":1401043243000,"specialFlag":false},{"locationId":"5afc9920-6817-4404-9605-3501fddbb4c4","latitude":40.41745461523533,"accuracy":10.0,"longitude":-122.24043055437505,"altitude":114.20001220703125,"timeStampMs":1401043509000,"specialFlag":false}],"installationId":"bcf7210f-2ab3-4a66-9cf9-256687d99c46","sortieId":"e74c1cd8-9464-4126-96d5-f919d5898b27"}' https://mellow-heeler-test.appspot.com/ws/v1/location
#