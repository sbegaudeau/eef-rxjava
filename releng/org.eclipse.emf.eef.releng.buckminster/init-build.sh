#!/bin/sh
rm -rf buildroot EEF.*
mkdir buildroot
:
COMPACT_BUILD_ID="${BUILD_ID//[-_]}"
COMPACT_BUILD_ID="${COMPACT_BUILD_ID:0:12}"
:
{
	cat "${WORKSPACE}/org.eclipse.emf/org.eclipse.emf.eef/releng/org.eclipse.emf.eef.releng.buckminster/releng/eef-build.properties"

	echo
	echo "# Define the Build ID (added by Hudson job definition)"
	echo "build.id=${BUILD_TYPE}${COMPACT_BUILD_ID}"

	echo
	echo "# Define the Build Alias (added by Hudson job definition)"
	echo "build.alias=${BUILD_ALIAS}"

	echo
	echo "# Define Hudson Build ID (added by Hudson job definition)"
	echo "hudson.build.id=${BUILD_ID}"

	echo
	echo "# Override default locations (added by Hudson job definition)"
	echo "buckminster.output.root=${WORKSPACE}/buildroot/buckminster.build"
	echo "buckminster.temp.root=${WORKSPACE}/buildroot/buckminster.temp"
	echo "eclipse.staging.area=/home/data/httpd/download-staging.priv/modeling/emft/eef"

	echo
	echo "# Site Signing (added by Hudson job definition)"
        test "${BUILD_TYPE}" != 'N' && (echo site.signing=true)
        test "${BUILD_TYPE}" == 'N' && (echo site.signing=false)

} > buildroot/build.properties

