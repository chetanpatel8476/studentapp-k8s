#!/bin/bash
sed "s/tagVersion/$1/g" studentapp-deploy/studentapp/studentapp-deployment.yaml 
