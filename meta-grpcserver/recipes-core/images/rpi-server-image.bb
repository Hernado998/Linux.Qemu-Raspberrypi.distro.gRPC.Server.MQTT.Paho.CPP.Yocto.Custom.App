require recipes-core/images/rpi-basic-image.bb
IMAGE_INSTALL += "grpcserver"
IMAGE_INSTALL += "paho-mqtt-cpp"
DISTRO_FEATURES += "wifi"
