#!/bin/bash
#
# Title:local_observation.sh
#
# Description:write mellow elephant observation datum
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"observationList":[{"frequency":1234,"sample":123,"timeStampMs":555,"observationId":"qrst"},{"frequency":4321,"sample":321,"timeStampMs":555,"observationId":"tsqr"}],"installationId":"51906849-d546-4358-ac5c-66936323e7e9","sortieId":"testSortie"}' http://127.0.0.1:8080/ws/v1/observation
#