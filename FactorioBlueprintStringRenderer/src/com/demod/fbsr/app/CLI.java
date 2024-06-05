package com.demod.fbsr.app;

import java.awt.image.BufferedImage;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.imageio.ImageIO;

import org.json.JSONObject;

import com.demod.fbsr.Blueprint;
import com.demod.fbsr.BlueprintStringData;
import com.demod.fbsr.FBSR;

public class CLI {
	public static void main(String[] args) throws Exception {
		Blueprint bp = new BlueprintStringData(Files.readString(Path.of(args[0]))).getBlueprints().get(0);
		BufferedImage image = FBSR.renderBlueprint(bp, new JSONObject());
		ImageIO.write(image, "PNG", new File(args[1]));
	}
}
