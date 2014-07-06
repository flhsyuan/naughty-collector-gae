#!/bin/bash
#
# Title:local_authorize.sh
#
# Description:mellow elephant authorization test
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"installationId":"demoInstallation"}' https://mellow-heeler-test.appspot.com/ws/v1/authorize
#
curl -v -H "Content-Type:application/json" -d '{"installationId":"bcf7210f-2ab3-4a66-9cf9-256687d99c46"}' https://mellow-heeler-test.appspot.com/ws/v1/authorize
#
