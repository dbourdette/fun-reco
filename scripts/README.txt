mongoexport -h {host} -d community -c facebook.profiles -o facebook.profiles.json
mongoexport -h {host} -d community -c facebook.opengraph.actions -o facebook.opengraph.actions.json
mongoexport -h {host} -d community -c facebook.opengraph.queries -o facebook.opengraph.queries.json
mongoexport -h {host} -d community -c facebook.opengraph.recommandations -o facebook.opengraph.recommandations.json
mongoexport -h {host} -d community -c facebook.friends -o facebook.friends.json