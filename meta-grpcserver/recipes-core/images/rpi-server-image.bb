require recipes-core/images/rpi-basic-image.bb
IMAGE_INSTALL += "grpcserver"
IMAGE_INSTALL += "paho-mqtt-cpp"
DISTRO_FEATURES += "wifi"
IMAGE_INSTALL_append = "\
     linux-firmware-rpidistro-bcm43430 \
     linux-firmware-rpidistro-bcm43455 \
     bluez-firmware-rpidistro-bcm43430a1-hcd \
     bluez-firmware-rpidistro-bcm4345c0-hcd \
"
