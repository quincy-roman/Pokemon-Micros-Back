import pokebase as pb
import json
import sys


# A script that fetches all of the pokemon from the API and then stores
# them as a JSON object that we can parse later to put into a database


def getmonster(id):
    # Object to get all the variables
    global dex_entry
    mon = pb.pokemon(id)

    hp = mon.stats[0].base_stat
    attack = mon.stats[1].base_stat
    defense = mon.stats[2].base_stat
    special_attack = mon.stats[3].base_stat
    special_defense = mon.stats[4].base_stat
    speed = mon.stats[5].base_stat
    stats = [hp, attack, defense, special_attack, special_defense, speed]

    species_name = mon.name
    type_one = mon.types[0].type.name
    if len(mon.types) > 1:
        type_two = mon.types[1].type.name
    else:
        type_two = ''
    ability = mon.abilities[0].ability.name

    species = pb.pokemon_species(id)

    if species.evolves_from_species is None:
        evolves_from = 'None'
    else:
        evolves_from = species.evolves_from_species.name

    i = 0
    while True:
        if species.flavor_text_entries[i].language.name == "en":
            dex_entry = species.flavor_text_entries[i].flavor_text
            break
        else:
            i += 1
            continue

    return json.dumps({
        "national_id": id,
        "species": species_name,
        "stats": stats,
        "type_one": type_one,
        "type_two": type_two,
        "ability": ability,
        "pre-evolution": evolves_from,
        "dex entry": dex_entry})



with open('Poke.txt', 'w') as f:
    sys.stdout = f
    for n in range(1, 152):
        print(getmonster(n))
