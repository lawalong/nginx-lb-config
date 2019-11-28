FILE=ipwall/blacklist.conf_new
if [ -f "$FILE" ]; then
    echo "$FILE exist"

    echo "backup..."
    cp ipwall/blacklist.conf ipwall/blacklist.conf_bk

    echo "override..."
    mv ipwall/blacklist.conf_new ipwall/blacklist.conf
    
    echo "Nginx reload.."
    docker container exec nglb nginx -s reload
fi
