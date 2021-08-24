DESCRIPTION = "grpc server application"
LICENSE = "CLOSED"

 
PR ="n0"

SRC_URI += "git://github.com/Hernado998/gRPC.Server.MQTT.PAHO.CPP.git;protocol=https"
SRCREV = "39ba1145c6df90b6e55f771556bb8e013bdacf4e"
 

S = "${WORKDIR}/git"

DEPENDS += "grpc-native grpc protobuf-native protobuf c-ares protobuf-c-native grpc"
DEPENDS += "openssl paho-mqtt-c paho-mqtt-cpp"



 
INSANE_SKIP_${PN} += "ldflags"
#inherit autotools
do_configure(){
	oe_runmake clean
}
do_configure(){
	oe_runmake all
}
do_install(){
    install -d ${D}${bindir}
    install -m 0755 ${S}/client ${D}${bindir}
    install -m 0755 ${S}/server ${D}${bindir}
}

 

FILES_${PN} = "/usr/bin/*"
