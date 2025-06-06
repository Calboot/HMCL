/*
 * Hello Minecraft! Launcher
 * Copyright (C) 2021  huangyuhui <huanghongxun2008@126.com> and contributors
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package org.jackhuang.hmcl.game;

import org.jackhuang.hmcl.java.JavaRuntime;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.Serializable;
import java.net.Proxy;
import java.util.*;

/**
 *
 * @author huangyuhui
 */
public class LaunchOptions implements Serializable {

    private File gameDir;
    private JavaRuntime java;
    private String versionName;
    private String versionType;
    private String profileName;
    private final List<String> gameArguments = new ArrayList<>();
    private final List<String> overrideJavaArguments = new ArrayList<>();
    private final List<String> javaArguments = new ArrayList<>();
    private final List<String> javaAgents = new ArrayList<>(0);
    private final Map<String, String> environmentVariables = new LinkedHashMap<>();
    private Integer minMemory;
    private Integer maxMemory;
    private Integer metaspace;
    private Integer width;
    private Integer height;
    private boolean fullscreen;
    private String serverIp;
    private String wrapper;
    private Proxy.Type proxyType;
    private String proxyHost;
    private int proxyPort;
    private String proxyUser;
    private String proxyPass;
    private boolean noGeneratedJVMArgs;
    private String preLaunchCommand;
    private String postExitCommand;
    private NativesDirectoryType nativesDirType;
    private String nativesDir;
    private ProcessPriority processPriority = ProcessPriority.NORMAL;
    private Renderer renderer = Renderer.DEFAULT;
    private boolean useNativeGLFW;
    private boolean useNativeOpenAL;
    private boolean daemon;

    /**
     * The game directory
     */
    public File getGameDir() {
        return gameDir;
    }

    /**
     * The Java Environment that Minecraft runs on.
     */
    public JavaRuntime getJava() {
        return java;
    }

    /**
     * Will shown in the left bottom corner of the main menu of Minecraft.
     * null if use the id of launch version.
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * Will shown in the left bottom corner of the main menu of Minecraft.
     * null if use Version.versionType.
     */
    public String getVersionType() {
        return versionType;
    }

    /**
     * Don't know what the hell this is.
     */
    public String getProfileName() {
        return profileName;
    }

    /**
     * User custom additional minecraft command line arguments.
     */
    @NotNull
    public List<String> getGameArguments() {
        return Collections.unmodifiableList(gameArguments);
    }

    /**
     * The highest priority JVM arguments (overrides the version setting)
     */
    @NotNull
    public List<String> getOverrideJavaArguments() {
        return Collections.unmodifiableList(overrideJavaArguments);
    }

    /**
     * User custom additional java virtual machine command line arguments.
     */
    @NotNull
    public List<String> getJavaArguments() {
        return Collections.unmodifiableList(javaArguments);
    }

    @NotNull
    public List<String> getJavaAgents() {
        return Collections.unmodifiableList(javaAgents);
    }

    public Map<String, String> getEnvironmentVariables() {
        return environmentVariables;
    }

    /**
     * The minimum memory that the JVM can allocate.
     */
    public Integer getMinMemory() {
        return minMemory;
    }

    /**
     * The maximum memory that the JVM can allocate.
     */
    public Integer getMaxMemory() {
        return maxMemory;
    }

    /**
     * The maximum metaspace memory that the JVM can allocate.
     * For Java 7 -XX:PermSize and Java 8 -XX:MetaspaceSize
     * Containing class instances.
     */
    public Integer getMetaspace() {
        return metaspace;
    }

    /**
     * The initial game window width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * The initial game window height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * Is inital game window fullscreen.
     */
    public boolean isFullscreen() {
        return fullscreen;
    }

    /**
     * The server ip that will connect to when enter game main menu.
     */
    public String getServerIp() {
        return serverIp;
    }

    /**
     * i.e. optirun
     */
    public String getWrapper() {
        return wrapper;
    }

    public Proxy.Type getProxyType() {
        return proxyType;
    }

    public String getProxyHost() {
        return proxyHost;
    }

    public int getProxyPort() {
        return proxyPort;
    }

    /**
     * The user name of the proxy, optional.
     */
    public String getProxyUser() {
        return proxyUser;
    }

    /**
     * The password of the proxy, optional
     */
    public String getProxyPass() {
        return proxyPass;
    }

    /**
     * Prevent game launcher from generating default JVM arguments like max memory.
     */
    public boolean isNoGeneratedJVMArgs() {
        return noGeneratedJVMArgs;
    }

    /**
     * Command called before game launches.
     */
    public String getPreLaunchCommand() {
        return preLaunchCommand;
    }

    /**
     * Command called after game exits.
     */
    public String getPostExitCommand() {
        return postExitCommand;
    }

    /**
     * 0 - ./minecraft/versions/&lt;version&gt;/natives
     * 1 - custom natives directory
     */
    public NativesDirectoryType getNativesDirType() {
        return nativesDirType;
    }

    /**
     * Path to the natives directory, optional
     */
    public String getNativesDir() {
        return nativesDir;
    }

    /**
     * Process priority
     */
    public ProcessPriority getProcessPriority() {
        return processPriority;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public boolean isUseNativeGLFW() {
        return useNativeGLFW;
    }

    public boolean isUseNativeOpenAL() {
        return useNativeOpenAL;
    }

    /**
     * Will launcher keeps alive after game launched or not.
     */
    public boolean isDaemon() {
        return daemon;
    }

    public static class Builder {

        private final LaunchOptions options = new LaunchOptions();

        public LaunchOptions create() {
            return options;
        }

        /**
         * User custom additional minecraft command line arguments.
         */
        public List<String> getGameArguments() {
            return options.gameArguments;
        }

        /**
         * The highest priority JVM arguments (overrides the version setting)
         */
        public List<String> getOverrideJavaArguments() {
            return options.overrideJavaArguments;
        }

        /**
         * User custom additional java virtual machine command line arguments.
         */
        public List<String> getJavaArguments() {
            return options.javaArguments;
        }

        public List<String> getJavaAgents() {
            return options.javaAgents;
        }

        public Builder setGameDir(File gameDir) {
            options.gameDir = gameDir;
            return this;
        }

        public Builder setJava(JavaRuntime java) {
            options.java = java;
            return this;
        }

        public Builder setVersionName(String versionName) {
            options.versionName = versionName;
            return this;
        }

        public Builder setVersionType(String versionType) {
            options.versionType = versionType;
            return this;
        }

        public Builder setProfileName(String profileName) {
            options.profileName = profileName;
            return this;
        }

        public Builder setGameArguments(List<String> gameArguments) {
            options.gameArguments.clear();
            options.gameArguments.addAll(gameArguments);
            return this;
        }

        public Builder setOverrideJavaArguments(List<String> overrideJavaArguments) {
            options.overrideJavaArguments.clear();
            options.overrideJavaArguments.addAll(overrideJavaArguments);
            return this;
        }

        public Builder setJavaArguments(List<String> javaArguments) {
            options.javaArguments.clear();
            options.javaArguments.addAll(javaArguments);
            return this;
        }

        public Builder setJavaAgents(List<String> javaAgents) {
            options.javaAgents.clear();
            options.javaAgents.addAll(javaAgents);
            return this;
        }

        public Builder setEnvironmentVariables(Map<String, String> env) {
            options.environmentVariables.clear();
            options.environmentVariables.putAll(env);
            return this;
        }

        public Builder setMinMemory(Integer minMemory) {
            options.minMemory = minMemory;
            return this;
        }

        public Builder setMaxMemory(Integer maxMemory) {
            options.maxMemory = maxMemory;
            return this;
        }

        public Builder setMetaspace(Integer metaspace) {
            options.metaspace = metaspace;
            return this;
        }

        public Builder setWidth(Integer width) {
            options.width = width;
            return this;
        }

        public Builder setHeight(Integer height) {
            options.height = height;
            return this;
        }

        public Builder setFullscreen(boolean fullscreen) {
            options.fullscreen = fullscreen;
            return this;
        }

        public Builder setServerIp(String serverIp) {
            options.serverIp = serverIp;
            return this;
        }

        public Builder setWrapper(String wrapper) {
            options.wrapper = wrapper;
            return this;
        }

        public Builder setProxyType(Proxy.Type proxyType) {
            options.proxyType = proxyType;
            return this;
        }

        public Builder setProxyHost(String proxyHost) {
            options.proxyHost = proxyHost;
            return this;
        }

        public Builder setProxyPort(int proxyPort) {
            options.proxyPort = proxyPort;
            return this;
        }

        public Builder setProxyUser(String proxyUser) {
            options.proxyUser = proxyUser;
            return this;
        }

        public Builder setProxyPass(String proxyPass) {
            options.proxyPass = proxyPass;
            return this;
        }

        public Builder setNoGeneratedJVMArgs(boolean noGeneratedJVMArgs) {
            options.noGeneratedJVMArgs = noGeneratedJVMArgs;
            return this;
        }

        public Builder setPreLaunchCommand(String preLaunchCommand) {
            options.preLaunchCommand = preLaunchCommand;
            return this;
        }

        public Builder setPostExitCommand(String postExitCommand) {
            options.postExitCommand = postExitCommand;
            return this;
        }

        public Builder setNativesDirType(NativesDirectoryType nativesDirType) {
            options.nativesDirType = nativesDirType;
            return this;
        }

        public Builder setNativesDir(String nativesDir) {
            options.nativesDir = nativesDir;
            return this;
        }

        public Builder setProcessPriority(@NotNull ProcessPriority processPriority) {
            options.processPriority = processPriority;
            return this;
        }

        public Builder setRenderer(@NotNull Renderer renderer) {
            options.renderer = renderer;
            return this;
        }

        public Builder setUseNativeGLFW(boolean useNativeGLFW) {
            options.useNativeGLFW = useNativeGLFW;
            return this;
        }

        public Builder setUseNativeOpenAL(boolean useNativeOpenAL) {
            options.useNativeOpenAL = useNativeOpenAL;
            return this;
        }

        public Builder setDaemon(boolean daemon) {
            options.daemon = daemon;
            return this;
        }

    }
}
