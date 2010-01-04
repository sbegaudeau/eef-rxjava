echo "$DATE: getting last successful build" >> $logFile
mkdir -p $BUILD_LOC
rm -f $BUILD_LOC/build.zip
rm -rf $BUILD_LOC/build
cd $BUILD_LOC
wget --no-check-certificate "https://build.eclipse.org/hudson/job/cbi-emf-eef-0.7-nightly/lastSuccessfulBuild/artifact/build/*zip*/build.zip"
if [ ! -f build.zip ]; then echo "ERROR:build.zip (from Hudson) not found" >> $logFile; exit -2; fi
unzip build.zip
echo "$DATE: publishing nightly build ..." >> $logFile
mkdir -p /home/data/users/sbouchet/promo_logs
$ANT -f /opt/users/hudsonbuild/.hudson/jobs/cbi-emf-eef-0.7-nightly/workspace/build/org.eclipse.eef.releng/promote.xml -Dpromote.properties=/opt/users/hudsonbuild/.hudson/jobs/cbi-emf-eef-0.7-nightly/workspace/build/org.eclipse.eef.releng/promote-N.properties 2>/dev/null 1> /home/data/users/sbouchet/promo_logs/cbi-emf-eef-promo-N.txt
