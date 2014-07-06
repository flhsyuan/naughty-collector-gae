#!/bin/bash
#
# Title:remote_sortie.sh
#
# Description:write mellow elephant sortie datum
#
# Development Environment:OS X 10.8.5
#
# Legalise:Copyright (C) 2014 Digital Burro, INC.
#
# Author:G.S. Cole (guycole at gmail dot com)
#
curl -v -H "Content-Type:application/json" -d '{"installationId":"bcf7210f-2ab3-4a66-9cf9-256687d99c46","sortieId":"cbc43bbb-1767-4cba-b239-cfd838c0cd1c","timeStampMs":"1401045354000","sortieName":"Default Sortie"}' https://mellow-heeler-test.appspot.com/ws/v1/sortie
#
