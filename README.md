## Overview

QuickSpawn is a powerful and versatile plugin for managing your Minecraft server's spawn point. With QuickSpawn, you can set a precise spawn location, customize teleportation behaviors, and enhance player experience with configurable messages and sounds. Key features include:

  - Flexible Spawn Management: Set the spawn point with exact coordinates, yaw, and pitch.
  - Teleportation Controls: Teleport players to the spawn on join, first join, or death. Customize cooldowns and whether to overwrite existing respawn points.
  - Configurable Sounds and Messages: Play specific sounds for setting and teleporting to the spawn, and customize all related messages.



## Installation

  Download the Plugin:
    Obtain the latest version of QuickSpawn.

  Place the Plugin in Your Server:
    Move the downloaded .jar file into the plugins directory of your Minecraft server.

  Restart Your Server:
    Start or restart your Minecraft server to load the QuickSpawn plugin.

  Verify Installation:
    Check the server console for any errors related to the plugin. You should also see a message indicating that QuickSpawn has been enabled.

## Usage

Commands

  -/spawn: Teleports you to the server spawn.

  - /setspawn: Sets the current location as the server spawn.

  - /reload: Reloads the plugin configuration.

Permissions

  - quickspawn.spawn: Allows players to use the /spawn command. Default is true.
  - quickspawn.setspawn: Allows players to use the /setspawn command. Default is op.
  - quickspawn.reload: Allows players to use the /reload command. Default is op.

## CONFIGURATION

Configuration File

Located in plugins/QuickSpawn/config.ini, this file contains various settings you can customize.

Prefix

  - prefix: The prefix used in messages from the plugin. Format with Minecraft color codes.

Spawn Location

  - spawnWorld: The name of the world where the spawn location is set.
  - spawnLocationX: X coordinate of the spawn location.
  - spawnLocationY: Y coordinate of the spawn location.
  - spawnLocationZ: Z coordinate of the spawn location.
  - spawnYaw: The yaw of the spawn location.
  - spawnPitch: The pitch of the spawn location.

Cooldown

  - cooldown: Time in milliseconds that players must wait to use /spawn again. You can disable this by setting it to 0.

Teleportation Settings

  - teleportOnDeath: Set to yes to teleport players to the spawn upon death.
  - forceTeleportOnDeath: Set to yes to overwrite all other respawn points with the server spawn.
  - teleportOnJoin: Set to yes to teleport players to the spawn every time they join.
  - teleportOnFirstJoin: Set to yes to teleport players to the spawn when they join for the first time.

Sounds

  - setSpawnSound: Sound played when the spawn is set. Leave empty if no sound.
  - teleportToSpawnSound: Sound played when teleporting to spawn. Leave empty if no sound.

Messages

  - tryingToReloadMessage: Message shown when reloading the plugin.
  - successfullyReloadedMessage: Message shown when the plugin is successfully reloaded.
  - errorReloading1Message: Message shown when there is an error reloading the plugin.
  - errorReloading2Message: Additional information for reload errors.
  - setServerSpawnMessage: Message shown when the server spawn is successfully set.
  - spawnNotSetMessage: Message shown when /spawn is used and no spawn is set.
  - teleportedToSpawnMessage: Message shown in chat when teleported to the spawn.
  - bigTeleportedToSpawnTitleMessage: Title message shown on screen when teleported to the spawn.
  - bigTeleportedToSpawnSubTitleMessage: Subtitle message shown on screen when teleported to the spawn.
  - cooldownMessage: Message shown when the cooldown is active.


Troubleshooting

  - Plugin Not Working: Ensure there are no errors in the server console. Verify the plugin version is compatible with your server version.

  - Commands Not Working: Check if permissions are correctly assigned and that the player has the necessary permissions.

Support
For further assistance, send a DM to @lucanuscervus on discord.
